import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-searchreview',
  templateUrl: './searchreview.component.html',
  styleUrls: ['./searchreview.component.css']
})
export class SearchreviewComponent implements OnInit{

  form!: FormGroup

  constructor(private fb: FormBuilder, private router: Router){}

  ngOnInit(): void {
    this.form=this.createForm()
  }

  private createForm(): FormGroup{
    return this.fb.group({
      movieName: this.fb.control<string>('',[Validators.required,Validators.minLength(2),this.noBlankSpaceValidator])
    })
  }

  //for detecting leading blank spaces
  public noBlankSpaceValidator(control: FormControl) {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : { 'whitespace': true };
}

  search(){
    const movieName=this.form?.value['movieName'];
    console.log("Search for ->",movieName);
    this.router.navigate(['/search',movieName])
  }
}
