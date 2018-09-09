import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { IndexPageComponent } from "./index-page/index-page.component";
import { NewsPageComponent } from "./news-page/news-page.component";
import { ThirdPageComponent } from "./third-page/third-page.component";
import { NewsDetailPageComponent } from "./news-detail-page/news-detail-page.component";
import { Error404PageComponent } from "./error404-page/error404-page.component";

const routes: Routes = [
    {path: "", component: IndexPageComponent, pathMatch: "full"},
    {path: "news", component: NewsPageComponent},
    {path: "news/:id", component: NewsDetailPageComponent},
    {path: "third", component: ThirdPageComponent},
    {path: "404", component: Error404PageComponent},
    {path: "**", redirectTo: "/404"}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRouterModule {

}
