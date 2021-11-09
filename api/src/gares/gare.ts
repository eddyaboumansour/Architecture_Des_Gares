import { Entity } from "typeorm"

@Entity()
export class Gare {
     datasetid: string
     recordid: string
     date_de_numerisation: string
     periode: string
     lieux: string
     origine_compagnie_sncf: string
     sous_thematique: string
     url_de_l_archive: string
     lieux_de_conservation: string
     coordx: string
     coordy: string
     thematique: string
     date: string
     legende: string
     mots_cles_separe_par_une_virgule: string
     cote_page: string
     typologie: string
     cote_sardo_reference: string
     images: string
     titre: string
     description_technique_document_original: string
     id: string
     url_de_la_capture_d_ecran: string
     favoris: boolean = false


}



