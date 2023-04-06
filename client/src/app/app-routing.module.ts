import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchreviewComponent } from './components/searchreview.component';
import { MoviereviewslistComponent } from './components/moviereviewslist.component';
import { PostcommentComponent } from './components/postcomment.component';

const routes: Routes = [
  //view 0
  {path: '', component:SearchreviewComponent},
  {path: 'search/:movieName', component:MoviereviewslistComponent},
  {path: 'comment/:title', component:PostcommentComponent},
  {path: '**', redirectTo: '',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
