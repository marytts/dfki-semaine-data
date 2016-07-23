# dfki-semaine-data

Speech databases for the British English TTS voices in the [SEMAINE project](http://www.semaine-project.eu/).

## Subsets

There are four speakers, each acting out a character in a specific expressive speaking style.

| Female                                                                    | Male                                                                |
| :-----------------------------------------------------------------------: | :-----------------------------------------------------------------: |
| ![](poppy/Poppy-100.jpg)<br>__Poppy__ is outgoing and optimistic          | ![](obadiah/Obadiah-100.jpg)<br>__Obadiah__ is gloomy and depressed |
| Duration 1h46m49s                                                         | Duration 2h03m53s                                                   |
| ![](prudence/Prudence-100.jpg)<br>__Prudence__ is pragmatic and practical | ![](spike/Spike-100.jpg)<br>__Spike__ is angry and argumentative    |
| Duration 3h45m47s                                                         | Duration 2h14m05s                                                   |

## Format

The audio data is provided in a single [FLAC](https://xiph.org/flac/) file per subset, recorded at 44.1 kHz sampling frequency with 16 bit per sample.
The textual data is provided in a single [YAML](http://yaml.org/) file per subset.
These files are a list of utterances, each of which contains
- a **prompt** code (file basename),
- the utterance **text**,
- a **date** timestamp (when the recording was created, in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format),
- utterance **start** and **end** times (in seconds) in the FLAC file,
- optionally, the phonetic **segments**, each of which has
    - a **lab**el (based on [SAMPA](http://www.phon.ucl.ac.uk/home/sampa/english.htm), `_` denotes silence), and
    - **end** time (in seconds) _relative to that utterance's **start** time_

For example,
```yaml
- prompt: uni56
  text: Yes.
  date: 2009-06-12T09:59:34Z
  start: 7961.79
  end: 7964.07
  segments:
  - lab: _
    end: 0.99
  - lab: j
    end: 1.07134
  - lab: E
    end: 1.2
  - lab: s
    end: 1.465
  - lab: _
    end: 3.135
```

## Downloading the data

Use the links on the [releases](../../releases) page.

## Converting the data

For convenience, the utterances for each subset can be be extracted from the YAML and FLAC files using simple commands.
After cloning or downloading and unpacking this repository, run `./gradlew tasks` (or `gradlew tasks` on Windows) for details.

### Prerequisites

You will need [Java](https://www.java.com/) to run the conversion tasks. Extracting the utterances to WAV files also requires [`sox`](http://sox.sourceforge.net/) to be installed.

### Copyright and license

Copyright 2009 [DFKI GmbH](http://dfki.de/).

[![Creative Commons License](http://mirrors.creativecommons.org/presskit/buttons/88x31/svg/by-nc-sa.svg)](http://creativecommons.org/licenses/by-nc-sa/4.0/)

This work is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License](http://creativecommons.org/licenses/by-nc-sa/4.0/).
