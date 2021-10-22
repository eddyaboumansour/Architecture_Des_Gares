import { HttpService } from '@nestjs/axios';
import { Injectable, OnModuleInit, Query } from '@nestjs/common';
import { Gare } from './gare';

@Injectable()
export class GaresService implements OnModuleInit{
//private gareStorage=new Map<string,Gare>();
private gareStorage=new Map<string,Gare>();
private datalink='https://data.opendatasoft.com/api/records/1.0/search/?dataset=archives-sncf-new%40datasncf&q=&sort=-id&facet=thematique&facet=sous_thematique&refine.sous_thematique=Architecture+des+gares'
private gareFill=new Gare();
  constructor(private httpService:HttpService)
  { }

  async onModuleInit() {

    const externalGares =await this.httpService.get<Gare[]>(this.datalink).subscribe(
      gare=>{
        gare.data['records'].forEach(gare => {
         
          
              this.gareFill.datasetid=gare['datasetid'] 
              this.gareFill.recordid=gare['recordid'] 
              this.gareFill.date_de_numerisation=gare['fields']['date_de_numerisation'] 
              this.gareFill.periode=gare['fields']['periode'] 
              this.gareFill.lieux=gare['fields']['lieux'] 
              this.gareFill.origine_compagnie_sncf=gare['fields']['origine_compagnie_sncf'] 
              this.gareFill.sous_thematique=gare['fields']['sous_thematique'] 
              this.gareFill.url_de_l_archive=gare['fields']['url_de_l_archive'] 
              this.gareFill.lieux_de_conservation=gare['fields']['lieux_de_conservation'] 
              this.gareFill.coordx=gare['fields']['coordonnees_geographique'][0] 
              this.gareFill.coordy=gare['fields']['coordonnees_geographique'][1] 
              this.gareFill.thematique=gare['fields']['thematique'] 
              this.gareFill.date=gare['fields']['date'] 
              this.gareFill.legende=gare['fields']['legende'] 
              this.gareFill.mots_cles_separe_par_une_virgule=gare['fields']['mots_cles_separe_par_une_virgule'] 
              this.gareFill.cote_page=gare['fields']['cote_page'] 
              this.gareFill.typologie=gare['fields']['typologie'] 
              this.gareFill. cote_sardo_reference=gare['fields']['cote_sardo_reference'] 
              this.gareFill.images=gare['fields']['images'] 
              this.gareFill.titre=gare['fields']['titre'] 
              this.gareFill.description_technique_document_original=gare['fields']['description_technique_document_original'] 
              this.gareFill.id=gare['fields']['id'] 
              this.gareFill.url_de_la_capture_d_ecran=gare['fields']['url_de_la_capture_d_ecran'] 
              
             this.addGare(this.gareFill)
             this.gareFill=new Gare();

        
    
    }
   
    )

  })}

  addGare(gare: Gare):void {

   
    this.gareStorage.set(gare.titre,gare);
    
   
  }

  findAll(page:number,limit:number):Gare[] {
    return Array.from(this.gareStorage.values()).sort((gare1,gare2)=> gare1.titre.localeCompare(gare2.titre)).slice((page-1)*limit,page*limit)
    
  }




  search(titre: string,page:number,limit:number):Gare[] {
  

    const escapedTerm = titre.toLowerCase().trim();

    return Array.from(this.gareStorage.values()).filter((gare) => {
      return (
          gare.titre.toLowerCase().includes(escapedTerm)
      );
    }).sort((gare1,gare2)=> gare1.titre.localeCompare(gare2.titre)).slice((page-1)*limit,page*limit);

  }

  update(titre: string, favoris:boolean) {
    return this.gareStorage.get(titre).favoris=favoris["favoris"];
  
  }

  // remove(id: number) {
  //   return `This action removes a #${id} gare`;
  // }
}
