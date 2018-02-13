import {VacancySkill} from "./vacancySkill";
import {Company} from "../home-page/Company";
import {TypeOfVacancy} from "./TypeOfVacancy";

export class Vacancy {
  id: number;
  info: string;
  typeOfVacancy: TypeOfVacancy;
  companyName: Company;
  skills: VacancySkill[];
}
