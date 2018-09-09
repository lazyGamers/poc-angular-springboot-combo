import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment";
import { Observable } from "rxjs";
import { News } from "../models/news.model";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: "root"
})
export class NewsService {

  private URL = `${environment.API}/resources`;

  constructor(private http: HttpClient) { }

  public getAllNews(): Observable<News[]> {
    return this.http
    .get(this.URL)
    .pipe(map(res => res as News[]));
  }

  public getOneNewsById(id: number): Observable<News> {
    const url = `${this.URL}/${id}`;
    return this.http
    .get(url)
    .pipe(map(res => res as News));
  }
}
