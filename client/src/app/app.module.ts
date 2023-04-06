import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchreviewComponent } from './components/searchreview.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MoviereviewslistComponent } from './components/moviereviewslist.component';
import { MovieService } from './service/movie.service';
import { HttpClientModule } from '@angular/common/http';
import { PostcommentComponent } from './components/postcomment.component';


@NgModule({
  declarations: [
    AppComponent,
    SearchreviewComponent,
    MoviereviewslistComponent,
    PostcommentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [MovieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
