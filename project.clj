(defproject display-my-medals "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.novemberain/monger "3.0.0-rc2"]
                 [com.stuartsierra/component "0.2.3"]
                 [http-kit "2.1.18"]
                 [compojure "1.1.5"]
                 [org.clojure/data.json "0.2.6"]
                 ]

  :main ^:skip-aot display-my-medals.bin.main
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
