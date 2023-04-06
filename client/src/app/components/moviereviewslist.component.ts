import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from '../service/movie.service';
import { Review } from '../models/review';
import { Subscription } from 'rxjs';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-moviereviewslist',
  templateUrl: './moviereviewslist.component.html',
  styleUrls: ['./moviereviewslist.component.css']
})
export class MoviereviewslistComponent implements OnInit,OnDestroy{

  movieName="";
  params$!: Subscription;
  reviews!: Review[];
  title="";

  constructor(private activatedRoute: ActivatedRoute,
    private mSvc: MovieService, private router: Router){

    }

  ngOnInit(): void {
    // this.mSvc.getReviews(this.movieName).then(response =>
    //   {
    //     this.reviews=response as Review[]
    //   })
    this.params$=this.activatedRoute.params.subscribe(
      async(params) => {
        this.movieName = params['movieName'];
        console.log(this.movieName);
        const r = await this.mSvc.getReviews(this.movieName);
        if (r === undefined || r.length == 0) {
          this.router.navigate(['/'])
        }else{
            this.reviews = r;
        }
      }
    )
  }

  ngOnDestroy(): void {

  }

  postcomment(i: number){
    this.title=this.reviews[i].title
    this.router.navigate(['/comment',this.title]);
  }
}
