(ns display-my-medals.bin.main
  (:gen-class)
  (:require [display-my-medals.core :as core]))

(defn -main [& args]
    (core/go))