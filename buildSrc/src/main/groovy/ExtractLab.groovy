import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

import org.yaml.snakeyaml.Yaml

class ExtractLab extends DefaultTask {

    @InputFile
    File yamlFile = project.findProperty('yamlFile')

    @OutputDirectory
    File destDir = project.file("$project.buildDir/lab")

    @TaskAction
    void extract() {
        new Yaml().load(yamlFile.newReader()).each { utterance ->
            if (utterance.segments) {
                project.file("$destDir/${utterance.prompt}.lab").withWriter { writer ->
                    writer.println '#'
                    utterance.segments.each { segment ->
                        writer.println "$segment.end 125 $segment.lab"
                    }
                }
            }
        }
    }
}
