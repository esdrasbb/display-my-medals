(ns display-my-medals.component.handler
  (:require [compojure.handler :as handler]
            [compojure.core :refer [defroutes context routes]]
            [compojure.route :as route]
            [compojure.core :as comp]
            [clojure.data.json :as json]
            [display-my-medals.component.service :as service]
            [com.stuartsierra.component :as component]))

(defn home-routes []
  (comp/routes
    (comp/GET "/" [] (json/write-str {:body "iaeok"}))
    (comp/GET "/insert" [] (service/insert-user [:username "Test"]))
    (comp/GET "/find-all" [] (json/write-str (service/get-all-users [:db])))
    ))

(defroutes
  app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(defn get-all-routes []
  (routes
    (home-routes)
    app-routes))

(defn make-handler []
  (-> (get-all-routes)
    (handler/site)))

(defrecord Handler [db]
  component/Lifecycle
  (start [component]
    (assoc component :handler (make-handler)))
  (stop [component]
    (assoc component :handler nil)))

(defn new-handler []
  (map->Handler {})
  )