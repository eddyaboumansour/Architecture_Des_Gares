import { Controller, Get, Post, Body, Patch, Param, Delete } from '@nestjs/common';
import { Gare } from './gare';
import { GaresService } from './gares.service';


@Controller('gares')
export class GaresController {
  constructor(private readonly garesService: GaresService) {}

  @Post()
  create(@Body() gare: Gare) {
    return this.garesService.addGare(gare);
  }

  @Get()
  findAll() {
    return this.garesService.findAll();
  }

  @Get(':titre')
  findOne(@Param('titre') titre: string) {
    return this.garesService.search(titre);
  }

  @Patch(':titre')
  update(@Param('titre') titre: string, @Body() favoris: boolean) {
    return this.garesService.update(titre, favoris);
  }

 // @Delete(':id')
  //remove(@Param('id') id: string) {
    //return this.garesService.remove(+id);
 // }
}
