(ns TB)

(def possible-words
  {:preword ["Crunchy " "Cheesy "]
   :prefix ["Gor" "Enchi"]
   :suffix ["rito " "dita "]
   :postword ["Pizza" "Salad"]})

(defn change-element [el val]
  (let [el (.getElementById js/document el)]
    (set! (. el -innerHTML) val)))

(defn test-func []
  (this-as that (set! (. that -innerHTML)
                    (rand-nth ((keyword (. that -id)) possible-words)))))

(defn bindClicks [selector]
  (.addEventListener (.getElementById js/document selector) "click" test-func))

(doseq [selector ["preword" "prefix" "suffix" "postword"]]
  (bindClicks selector) (change-element selector (rand-nth ((keyword selector) possible-words))))
