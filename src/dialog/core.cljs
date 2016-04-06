(ns dialog.core
  (:require [quiescent.core :as q]
            [quiescent.dom :as d]))

(defonce state
  (atom
   {:text "Hello world!"
    :count 0}))

(q/defcomponent App
  [val]
  (d/div {}
    (d/button {:onClick #(swap! state update :count inc)}
      "You've clicked me " (:count val) " times.")))

(defn render
  [data]
  (q/render
   (App data)
   (.getElementById js/document "app")))

(add-watch
 state
 ::render
 (fn [_ _ _ data] (render data)))

(defn ^:export main []
  (render @state))
