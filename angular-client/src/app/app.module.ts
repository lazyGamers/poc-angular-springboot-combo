import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import {HttpClientModule} from "@angular/common/http";
import { AppComponent } from "./app.component";
import { AppRouterModule } from "./app-router.module";
import {FormsModule} from "@angular/forms";
import { IndexPageComponent } from "./index-page/index-page.component";
import { NewsPageComponent } from "./news-page/news-page.component";
import { NewsDetailPageComponent } from "./news-detail-page/news-detail-page.component";
import { ThirdPageComponent } from "./third-page/third-page.component";
import { Error404PageComponent } from "./error404-page/error404-page.component";
import { NewsService } from "./services/news.service";

@NgModule({
  declarations: [
    AppComponent,
    IndexPageComponent,
    NewsPageComponent,
    NewsDetailPageComponent,
    ThirdPageComponent,
    Error404PageComponent
  ],
  imports: [
    BrowserModule,
    AppRouterModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    NewsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
