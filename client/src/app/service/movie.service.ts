import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom, lastValueFrom } from 'rxjs';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private API_URI: string="/api/search"

  constructor(private httpClient: HttpClient) { }

  getReviews(movieName: string):Promise<any>{
    const params = new HttpParams()
        .set("movieName",movieName);

    return lastValueFrom(this.httpClient
      .get(this.API_URI,{params}))

  }

  post(form: any){
    const formdata = new FormData();
    formdata.set("name",form['name']);
    formdata.set("rating",form['rating']);
    formdata.set("comment",form['comment']);

    return firstValueFrom(this.httpClient.post("/comment",formdata));
  }
}
