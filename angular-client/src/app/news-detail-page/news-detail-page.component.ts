import { Component, OnInit } from "@angular/core";
import { News } from "../models/news.model";
import { ActivatedRoute, Router } from "@angular/router";
import { NewsService } from "../services/news.service";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
  selector: "app-news-detail-page",
  templateUrl: "./news-detail-page.component.html",
  styleUrls: ["./news-detail-page.component.scss"]
})
export class NewsDetailPageComponent implements OnInit {

  public news: News;

  constructor(private activeRoute: ActivatedRoute, private router: Router, private newsService: NewsService) { }

  ngOnInit() {
    this.news = new News;
    this.getNewsDetail();
  }

  private getNewsDetail() {
    const id = this.activeRoute.snapshot.params.id;
    this.newsService.getOneNewsById(id).subscribe(
      (receivedNews: News) => {
        this.news = receivedNews;
      },
      (err: HttpErrorResponse) => {
        if (err.status === 404) {
          this.router.navigateByUrl("/404");
        } else {
          console.log(err);
        }
      }
    );
  }

}
