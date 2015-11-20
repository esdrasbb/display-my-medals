(ns display-my-medals.component.http-server
  (:require [org.httpkit.server :refer [run-server]]
            [com.stuartsierra.component :as component]))

(defrecord Http-server [port handler]
  component/Lifecycle
  (start [component]
    (println ";; Starting HTTP-Kit server on port" port)
    (assoc component :server (run-server (:handler handler) {:port port})))
  (stop [{:keys [server] :as component}]
    (when server (server))
    (assoc component :server nil)))

(defn create-http-server [port]
  (map->Http-server {:port port}))
