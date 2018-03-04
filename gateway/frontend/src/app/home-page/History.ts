import {UserCourses} from "./UserCourses";
import {Experience} from "./Experience";
import {Education} from "./Education";

export class History{
  id: number;
  date: number;
  userCourses: UserCourses;
  experience: Experience;
  education: Education;
  historyInfo: string;
}
