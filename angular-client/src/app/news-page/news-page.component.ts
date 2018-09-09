import { Component, OnInit } from "@angular/core";
import { NewsService } from "../services/news.service";
import { News } from "../models/news.model";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
  selector: "app-news-page",
  templateUrl: "./news-page.component.html",
  styleUrls: ["./news-page.component.scss"]
})
export class NewsPageComponent implements OnInit {

  public newsList: News[];

  constructor(private newsService: NewsService) { }

  ngOnInit() {
    this.newsList = [];
    this.getList();
  }

  private getList() {
    this.newsService.getAllNews().subscribe(
      (news: News[]) => {
        this.newsList = news;
      },
      (err: HttpErrorResponse) => {
        console.log("There was an error! ", err.status, err.statusText);
      }
    );
  }

}
