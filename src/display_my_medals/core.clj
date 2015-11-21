(ns display-my-medals.core
  (:require [com.stuartsierra.component :as component]
            [display-my-medals.component.system :as system]
            ))

(defn go []
  "Starts display-my-medals"
  (let [system (component/start
                 (system/load-system!
                   {:db-host "localhost" :db-name "medals" :port 8000}))]
    (-> (Runtime/getRuntime)
        (.addShutdownHook (Thread. #(component/stop system))))))