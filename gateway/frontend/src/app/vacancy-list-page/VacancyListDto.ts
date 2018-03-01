import {Vacancy} from "./vacancy";
import {Skill} from "../user-list-page/skill";
import {TaskListDto} from "./TaskListDto";
import {VacancySkill} from "./vacancySkill";

export class VacancyListDto{
  vacancy: Vacancy;
  skillDtoList: VacancySkill[];
  taskListDtoList: TaskListDto[];
}
