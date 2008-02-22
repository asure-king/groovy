package swing.binding.caricature

import groovy.swing.SwingBuilder
import java.awt.BorderLayout
import java.awt.Color
import javax.swing.border.TitledBorder

SwingBuilder.build {
    frame(pack:true, show:true, defaultCloseOperation:javax.swing.JFrame.DISPOSE_ON_CLOSE) {
        panel(constraints:BorderLayout.CENTER,) {
            // place in panel to insure square layout
            widget(new JCaricature(
                    background:Color.WHITE,
                    opaque:true),
                id:'caricature')
        }
        hbox(constraints:BorderLayout.SOUTH) {
            panel(border:new TitledBorder("Style")) {//, font:new Font
                gridLayout(new java.awt.GridLayout(5, 2))
                label("Eyes") // font stuff
                slider(id:'eyeSlider', minimum:0, maximum:4,
                    value:bind(target:caricature, targetProperty:'eyeStyle', value:2))
                label("Face") // font stuff
                slider(id:'faceSlider', minimum:0, maximum:4,
                    value:bind(target:caricature, targetProperty:'faceStyle', value:2))
                label("Mouth") // font stuff
                slider(id:'mouthSlider', minimum:0, maximum:4,
                    value:bind(target:caricature, targetProperty:'mouthStyle', value:2))
                label("Hair") // font stuff
                slider(id:'hairSlider', minimum:0, maximum:4,
                    value:bind(target:caricature, targetProperty:'hairStyle', value:2))
                label("Nose") // font stuff
                slider(id:'noseSlider', minimum:0, maximum:4,
                    value:bind(target:caricature, targetProperty:'noseStyle', value:2))
            }
            panel(border:new TitledBorder("Effects")) { //, font stuff
                gridLayout(new java.awt.GridLayout(2, 5))
                label("Rotation") // font stuff
                slider(id:'rotationSlider', maximum:360,
                    value:bind(target:caricature, targetProperty:'rotation', value:0))
                label("Scale") // font stuff
                slider(id:'scaleSlider', maximum: 150, minimum:50,
                    value:bind(target:caricature, targetProperty:'scale', converter: {it / 100f}, value:100))
            }
        }
    }
}
