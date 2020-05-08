package de.htwg.se.connect4.model

case class Matrix[Cell](rows:Vector[Vector[Cell]]) {

  def this(sizeOfRows:Int, sizeOfCol:Int, cell: Cell) = this(Vector.tabulate(sizeOfRows, sizeOfCol){(row, col) => cell})

  def size:Int = rows.size

  def cell(row:Int, col:Int): Cell = rows(row)(col)

  def replaceCell(row:Int, col:Int, cell:Cell): Matrix[Cell] = copy(rows.updated(row, rows(row).updated(col, cell)))

}