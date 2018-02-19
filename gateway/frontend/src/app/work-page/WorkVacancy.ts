import {Vacancy} from "../vacancy-list-page/vacancy";
import {VacancyTask} from "./VacancyTask";

export class WorkVacancy extends Vacancy{
  vacancyTasks: VacancyTask[];
}
