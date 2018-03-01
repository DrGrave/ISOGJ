
import {TaskSkillDto} from "./TaskSkillDto";
import {VacancyTask} from "../work-page/VacancyTask";

export class TaskListDto{
  taskDto: VacancyTask;
  taskSkillDtoList: TaskSkillDto[];
}
