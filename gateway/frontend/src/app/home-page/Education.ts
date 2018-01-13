import {TypeOfEducation} from "./TypeOfEducation";
import {Faculty} from "./Faculty";
import {School} from "./School";

export class Education{
  id: number;
  typeOfEducation: TypeOfEducation;
  dateOfEnd: Date;
  dateOfStart: Date;
  faculty: Faculty;
  School: School;
}
