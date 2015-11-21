(ns display-my-medals.component.mongodb
  (:require [monger.core :as mg]
            [com.stuartsierra.component :as component]))

(defrecord Database [host db-name db-port opts conn]
  component/Lifecycle
  (start [component]
    (println ";; Starting Mongod on port" db-port)
    (let [conn  (mg/connect {:host host
                             :port db-port})]
      (assoc component
        :conn conn
        :db (mg/get-db conn db-name))))
  (stop [{:keys [conn] :as component}]
    (when conn (mg/disconnect conn))
    (assoc component
      :conn nil
      :db nil)))

(defn create-database [host db-name & [{:keys [db-port]}]]
  (map->Database {:host host
                  :db-name db-name
                  :db-port (or db-port 27017)}))






