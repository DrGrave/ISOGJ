
import {UserSkill} from "./userSkill";
import {EducationDto} from "./EducationDto";

export class User {
  id: number;
  firstName: string;
  lastName: string;
  middleName: string;
  skill: UserSkill[];
  imgLink: string;
  education: EducationDto[];
}
