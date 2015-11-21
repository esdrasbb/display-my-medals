(ns display-my-medals.service.data
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

(defn insert-user [database username]
  (mc/insert database "robots" {:first_name username :last_name "Lennon"}))

(defn get-all-users [database]
  (mc/find-maps database "robots"))
