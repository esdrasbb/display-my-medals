(ns display-my-medals.routes
  (:require [compojure.core :as comp]
            [com.stuartsierra.component :as component]
            [clojure.data.json :as json]
            [display-my-medals.service.data :as data]))

(defn home-routes []
  (comp/routes
    (comp/GET "/" [] (json/write-str {:body "iaeok"}))
    (comp/GET "/insert" [] (data/insert-user [:username "Test"]))
    (comp/GET "/find-all" [] (json/write-str (data/get-all-users [])))))