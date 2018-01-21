
import {UserSkill} from "./userSkill";

export class User {
  id: number;
  firstName: string;
  lastName: string;
  middleName: string;
  skill: UserSkill[];
  imgLink: string;
}
