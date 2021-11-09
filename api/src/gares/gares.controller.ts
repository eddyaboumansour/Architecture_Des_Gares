import { Controller, Get, Post, Body, Patch, Param, Delete, Query } from '@nestjs/common';
import { Gare } from './gare';
import { GaresService } from './gares.service';


@Controller('gares')
export class GaresController {
  constructor(private readonly garesService: GaresService) { }

  @Post()
  create(@Body() gare: Gare) {
    return this.garesService.addGare(gare);
  }

  @Get()
  findAll(@Query('page') page: number = 1, @Query('limit') limit: number = 5) {
    return this.garesService.findAll(page, limit);
  }



  @Get(':titre')
  findOne(@Param('titre') titre: string, @Query('page') page: number = 1, @Query('limit') limit: number = 5) {
    return this.garesService.search(titre, page, limit);
  }

  @Patch(':titre')
  update(@Param('titre') titre: string, @Body() favoris: boolean) {
    return this.garesService.update(titre, favoris);
  }

}
