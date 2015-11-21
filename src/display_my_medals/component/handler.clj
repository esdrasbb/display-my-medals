(ns display-my-medals.component.handler
  (:require [compojure.handler :as handler]
            [compojure.core :refer [defroutes context routes]]
            [compojure.route :as route]
            [com.stuartsierra.component :as component]
            [display-my-medals.routes :as home-routes]))

(defroutes
  app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(defn get-all-routes []
  (routes
    (home-routes/home-routes)
    app-routes))

(defn make-handler []
  (-> (get-all-routes)
      (handler/site)))

(defrecord Handler [scheduler]
  component/Lifecycle
  (start [component]
    (assoc component :handler (make-handler)))
  (stop [component]
    (assoc component :handler nil)))

(defn new-handler []
  (map->Handler {}))