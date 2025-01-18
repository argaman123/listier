// Base Model Type
export interface Model {
  id: string;
}

// Base Column Type (Extending Model)
export interface BaseColumn extends Model {
  name: string;
}

// Specific Column Types
export interface TextColumn extends BaseColumn {
  type: "text";
}

export interface DateColumn extends BaseColumn {
  type: "date";
}

export interface SelectOption extends Model {
  label: string;
  color: string;
}

export interface SelectColumn extends BaseColumn {
  type: "select";
  options: SelectOption[];
}

// Union Type for Columns
export type Column = TextColumn | DateColumn | SelectColumn;

// Row Type (Extending Model)
export interface Row extends Model {}

// Base Cell Type (Extending Model)
export interface BaseCell extends Model {
  columnID: string;
  rowID: string;
}

// Specific Cell Types
export interface TextCell extends BaseCell {
  type: "text";
  content: string;
}

export interface SelectCell extends BaseCell {
  type: "select";
  selected: string[];
}

export interface DateCell extends BaseCell {
  type: "date";
  date: number;
}

// Union Type for Cells
export type Cell = TextCell | SelectCell | DateCell;

// Database Type
export interface Database {
  version: string;
  columns: Column[];
  rows: Row[];
  cells: Cell[];
}
