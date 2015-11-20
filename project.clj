(defproject display-my-medals "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [congomongo "0.4.6"]
                 [com.stuartsierra/component "0.2.3"]
                 [http-kit "2.1.18"]
                 [compojure "1.1.5"]
                 [lib-noir "0.8.1"]
                 ]

  :main ^:skip-aot display-my-medals.bin.main
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
