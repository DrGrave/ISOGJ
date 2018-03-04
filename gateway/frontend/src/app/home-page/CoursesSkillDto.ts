import {Courses} from "./Courses";
import {Skill} from "../user-list-page/skill";

export class CoursesSkillDto{
  id: number;
  courses: Courses;
  skill: Skill;
  mark: number;
}
