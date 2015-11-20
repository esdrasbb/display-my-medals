(ns display-my-medals.routes
  (:require [compojure.core :as comp]
            [noir.response :as resp]))

(defn index []
  (resp/json {:body "iaeok"}))

(defn home-routes []
  (comp/routes
    (comp/GET "/" req (index))))