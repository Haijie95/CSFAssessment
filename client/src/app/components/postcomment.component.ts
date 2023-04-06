import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { MovieService } from '../service/movie.service';


@Component({
  selector: 'app-postcomment',
  templateUrl: './postcomment.component.html',
  styleUrls: ['./postcomment.component.css']
})
export class PostcommentComponent {

  form!: FormGroup
  title!: string;
  params$!: Subscription;

  constructor(private activatedRoute: ActivatedRoute,
    private fb: FormBuilder, private router: Router,
    private mSvc: MovieService){}

  ngOnInit(): void {
    this.form=this.createForm()

    this.params$=this.activatedRoute.params.subscribe(
      async(params) => {
        this.title = params['title'];
        console.log(this.title);
      }
    )
  }

  private createForm(): FormGroup{
    return this.fb.group({
      name: this.fb.control<string>('',[Validators.required,Validators.minLength(3)]),
      rating: this.fb.control<number>(1),
      comment: this.fb.control<string>('',[Validators.required])
    })
  }

  postcomment(){
    const formVal=this.form.value
    this.mSvc.post(formVal)
    this.router.navigate(['/'])
  }
}
