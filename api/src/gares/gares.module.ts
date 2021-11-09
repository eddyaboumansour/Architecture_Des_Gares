import { Module } from '@nestjs/common';
import { GaresService } from './gares.service';
import { GaresController } from './gares.controller';
import { HttpModule } from '@nestjs/axios';


@Module({
  imports: [HttpModule],
  controllers: [GaresController],
  providers: [GaresService]
})
export class GaresModule { }
