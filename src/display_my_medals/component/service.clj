(ns display-my-medals.component.service
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

(defn insert-user [database username]
  (mc/insert database "robots" {:first_name username :last_name "Lennon"}))

(defn get-all-users [db]
  (mc/find-maps db "robots"))
