package de.htwg.se.connect4.aview.gui

import de.htwg.se.connect4.controller.Controller
import de.htwg.se.connect4.model.Color

import scala.swing.event.MouseClicked
import scala.swing.{BoxPanel, Color, Dimension, FlowPanel, Orientation, Swing}

class CellPanel(row: Int, col: Int, controller: Controller) extends FlowPanel {


  var cellColor = new Color(255, 250, 250)

  def cellColor(row: Int, col: Int): Color = {
    if (controller.board.cell(row, col).isSet) {
      if (controller.board.cell(row, col).color.get == Color.YELLOW) cellColor = new Color(255, 255, 0)
      else cellColor = new Color(255, 0, 0)
    } else cellColor = new Color(255, 250, 250)

    cellColor
  }


  val cell = new BoxPanel(Orientation.Vertical) {
    background = cellColor
    preferredSize = new Dimension(51, 51)
    border = Swing.BeveledBorder(Swing.Raised)

    listenTo(mouse.clicks)

    reactions += {
      case MouseClicked(src, pt, mod, clicks, pops) =>
        controller.handle(row.toString + col.toString, controller.board)
        background = cellColor(row, col)
        repaint()
    }
  }


  def redraw = {
    contents.clear()

    contents += cell

    repaint
  }

}
