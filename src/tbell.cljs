(ns TB)

(def possible-words
  {:preword ["Crunchy " "Cheesy " "Double Decker " "7 Layer " "1/2 lb " "Spicy " "Beefy " "Doritos " "Cantina " "Hard " "Crispy " "Volcano " "Supreme " "Fresco " "Soft " "Baja " "Fiesta " "Mexican " "Zesty " "Stuft " "XXL "]
   :prefix ["Gor" "Enchi" "Nacho" "Cha" "Mexi" "Quesa" "Soft" "Hard" "Steak"]
   :suffix ["rito " "dita " "grande " "ito " "lupa " "melt " "wrap " "dilla "]
   :postword ["Pizza" "Salad" "Roll-up" "Griller" "Bowl" "Taco" "Supreme" "Crunch" "Salad" "Taquito"]})

(defn dom-el [selector] (.getElementById js/document selector))

(defn change-element [selector val] (set! (. (dom-el selector) -innerHTML) val))

(defn replace-word []
  (this-as that
    (loop [selector (. that -id)
           el (dom-el selector)
           new-word (rand-nth ((keyword selector) possible-words))]

      (if (= (. el -innerText) new-word)
        (recur selector el (rand-nth ((keyword selector) possible-words)))
        (set! (. el -innerHTML) new-word)))))

(defn bindClicks [selector]
  (.addEventListener (dom-el selector) "click" replace-word))

(doseq [selector ["preword" "prefix" "suffix" "postword"]]
  (bindClicks selector) (change-element selector (rand-nth ((keyword selector) possible-words))))
