import {VacancySkill} from "./vacancySkill";

export class Vacancy {
  id: number;
  info: string;
  typeOfVacancy: string;
  companyName: string;
  skills: VacancySkill[];
}
