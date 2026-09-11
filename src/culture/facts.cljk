(ns culture.facts
  "Regional-culture catalog for Oslo -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"oslo"
   [{:culture/id "oslo.dish.faarikaal"
     :culture/name "Fårikål"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :dish
     :culture/summary "Traditional Norwegian casserole of mutton on the bone, cabbage and whole black pepper, cooked for several hours; the national dish of Norway rather than Oslo-specific."
     :culture/url "https://en.wikipedia.org/wiki/F%C3%A5rik%C3%A5l"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "oslo.dish.lutefisk"
     :culture/name "Lutefisk"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :dish
     :culture/summary "Dried whitefish, usually cod, cured in lye; a seafood dish of several Nordic countries, traditionally part of Christmas feasts in Norway."
     :culture/url "https://en.wikipedia.org/wiki/Lutefisk"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "oslo.dish.roemmegroet"
     :culture/name "Rømmegrøt"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :dish
     :culture/summary "Norwegian porridge made with sour cream, whole milk, wheat flour, butter and salt, traditionally prepared for special occasions and holidays in Norway."
     :culture/url "https://en.wikipedia.org/wiki/R%C3%B8mmegr%C3%B8t"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "oslo.product.brunost"
     :culture/name "Brunost"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :product
     :culture/summary "Norwegian brown whey cheese (mysost) made from whey, milk and cream, with a caramel-like sweetness from heated milk sugars; national rather than Oslo-specific."
     :culture/url "https://en.wikipedia.org/wiki/Brunost"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "oslo.beverage.ringnes"
     :culture/name "Ringnes"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :beverage
     :culture/summary "Beer from Ringnes, founded in 1876, whose brewery in the Grünerløkka district of Oslo produced its first beer in 1877."
     :culture/url "https://en.wikipedia.org/wiki/Ringnes"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "oslo.festival.holmenkollen-ski-festival"
     :culture/name "Holmenkollen Ski Festival"
     :culture/name-local "Holmenkollrennene"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :festival
     :culture/summary "Ski festival held at Holmenkollen in Oslo each March, arranged every year since 1892 except 1898 and during World War II."
     :culture/url "https://en.wikipedia.org/wiki/Holmenkollen_Ski_Festival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "oslo.festival.oeyafestivalen"
     :culture/name "Øyafestivalen"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :festival
     :culture/summary "Annual Norwegian music festival held in Tøyen Park, Oslo, grown since its start in 1999 into one of Norway's biggest and most important music festivals."
     :culture/url "https://en.wikipedia.org/wiki/%C3%98yafestivalen"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "oslo.heritage.akershus-fortress"
     :culture/name "Akershus Fortress"
     :culture/name-local "Akershus festning"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :heritage
     :culture/summary "Medieval castle on the Oslofjord in Oslo, built to protect and provide a royal residence for the city, later serving as military base and prison."
     :culture/url "https://en.wikipedia.org/wiki/Akershus_Fortress"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "oslo.heritage.frogner-park"
     :culture/name "Frogner Park"
     :culture/name-local "Frognerparken"
     :culture/municipality "oslo"
     :culture/country "NOR"
     :culture/kind :heritage
     :culture/summary "Public park in Oslo containing the Vigeland installation of sculptures; the most visited tourist attraction in Norway."
     :culture/url "https://en.wikipedia.org/wiki/Frogner_Park"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-nor-oslo culture catalog "
                 "(ADR-2607171400): " (count (get catalog "oslo"))
                 " Oslo entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
