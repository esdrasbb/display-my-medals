(ns display-my-medals.component.mongodb
  (:require [somnium.congomongo :as m]
            [com.stuartsierra.component :as component]))

(defrecord Database [host db-name db-port opts conn]
  component/Lifecycle
  (start [component]
    (println ";; Starting Mongod on port" db-port)
    (assoc component
      :conn (m/make-connection db-name
                               :host host
                               :port db-port)))
  (stop [{:keys [conn] :as component}]
    (when conn (m/close-connection conn))
    (assoc component
      :conn nil)))

(defn create-database [host db-name & [{:keys [db-port]}]]
  (map->Database {:host host
                  :db-name db-name
                  :db-port (or db-port 27017)}))
