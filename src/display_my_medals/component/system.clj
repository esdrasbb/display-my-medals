(ns display-my-medals.component.system
  (:require [com.stuartsierra.component :as component]
            [display-my-medals.component.mongodb :refer [create-database]]
            [display-my-medals.component.http-server :refer [create-http-server]]
            [display-my-medals.component.handler :refer [new-handler]]
            ))

(defn load-system! [config]
  (let [{:keys [db-host db-name port]} config]
    (component/system-map
      :db (component/using (create-database db-host db-name) [])
      :handler (component/using (new-handler) [:db])
      :server (component/using (create-http-server port) [:handler])
      )))