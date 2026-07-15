(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Oslo -- the FIFTEENTH
  municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen for the first
  fourteen) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL oslo.kommune.no (City of Oslo) HTML
  page -- never fabricated. An ordinance not in this table has NO
  spec-basis, full stop; extend `catalog`, do not invent an id/url/date.

  Both entries rendered fully via WebFetch with explicit dates stated
  directly in the page text.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"oslo"
   [{:ordinance/id "oslo.reglement-for-bystyret"
     :ordinance/title "Reglement for bystyret (Rules of Procedure for the City Council)"
     :ordinance/municipality "oslo"
     :ordinance/country "NOR"
     :ordinance/kind :ordinance
     :ordinance/url "https://www.oslo.kommune.no/politikk/reglement-for-folkevalgte/reglement-for-bystyret/"
     :ordinance/url-provenance :official-oslo-kommune-no
     :ordinance/enacted-date "2023-10-25"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:governance}}
    {:ordinance/id "oslo.forskrift-serverings-salgs-skjenkebevillinger"
     :ordinance/title "Forskrift om serverings-, salgs- og skjenkebevillinger i Oslo kommune"
     :ordinance/municipality "oslo"
     :ordinance/country "NOR"
     :ordinance/kind :ordinance
     :ordinance/url "https://www.oslo.kommune.no/skatt-og-naring/salg-servering-og-skjenking/apnings-og-skjenketider-for-serveringssteder/"
     :ordinance/url-provenance :official-oslo-kommune-no
     :ordinance/enacted-date "2025-04-30"
     :ordinance/retrieved-at "2026-07-15"
     :ordinance/topic #{:licensing}}]})

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
      :note (str "cloud-itonami-municipality-nor-oslo Wave 0 (ADR-2607141700): "
                 (count (get catalog "oslo")) " Oslo entries seeded "
                 "with an official oslo.kommune.no citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
