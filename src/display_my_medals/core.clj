(ns display-my-medals.core
  (:require [com.stuartsierra.component :as component]
            [display-my-medals.component.mongodb :refer [create-database]]
            [display-my-medals.component.http-server :refer [create-http-server]]
            [display-my-medals.component.handler :refer [new-handler]]
            ))

(defn init-system [config]
  (let [{:keys [db-host db-name port]} config]
    (component/system-map
      :handler (component/using (new-handler) [])
      :server (component/using (create-http-server port) [:handler])
      :db (component/using (create-database db-host db-name) []))))

(defn go []
  (component/start
    (init-system {:db-host "localhost" :db-name "medals" :port 8000})))