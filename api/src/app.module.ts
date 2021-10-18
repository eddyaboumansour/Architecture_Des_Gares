import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { GaresModule } from './gares/gares.module';

@Module({
  imports: [GaresModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
