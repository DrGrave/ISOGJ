import {TypeOfEducation} from "./TypeOfEducation";
import {School} from "./School";
import {Department} from "./Department";

export class Education{
  id: number;
  typeOfEducation: TypeOfEducation;
  dateOfEnd: Date;
  dateOfStart: Date;
  department: Department;
  School: School;
}
