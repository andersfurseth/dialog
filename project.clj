(defproject dialog "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.6.1"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.2.374" :exclusions [org.clojure/tools.reader]]
                 [reagent "0.6.0-alpha"]]
  :plugins [[lein-figwheel "0.5.2"]
            [lein-cljsbuild "1.1.3" :exclusions [[org.clojure/clojure]]]]
  :source-paths ["src"]
  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [figwheel-sidecar "0.5.0-1"]]
                   :source-paths ["cljs_src" "dev"]}}
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:on-jsload "dialog.core/on-js-reload"}
                :compiler {:main dialog.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/dialog.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/compiled/dialog.js"
                           :main dialog.core
                           :optimizations :advanced
                           :pretty-print false}}]}
  :figwheel {:css-dirs ["resources/public/css"]})
